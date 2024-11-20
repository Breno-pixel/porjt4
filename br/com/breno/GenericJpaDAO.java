package br.com.breno;

public class GenericJpaDAO<T extends Persistente, E extends Serializable> implements GenericDAO<T, E> {
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<T> persistenteClass;

    public GenericJpaDAO(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public void excluir(T entity) throws DAOException {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        closeConnection();
    }

    @Override
    public T buscar(E id) throws TipoChaveNaoEncontradaException, DAOException {
        openConnection();
        T entity = entityManager.find(persistenteClass, id);
        closeConnection();
        return entity;
    }

    @Override
    public List<T> buscarTodos() throws DAOException {
        openConnection();
        List<T> entities = entityManager.createQuery("select e from " + persistenteClass.getSimpleName() + " e", persistenteClass).getResultList();
        closeConnection();
        return entities;
    }

    private void openConnection() throws DAOException {
        if (entityManager == null) {
            entityManager = entityManagerFactory.createEntityManager();
        }
    }

    private void closeConnection() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
