package br.com.breno;

import static org.junit.Assert.assertTrue;

public class ClienteJpaDaoTest {
    private IClienteJpaDAO clienteDao;
    private Random rd;

    public ClienteJpaDaoTest() {
        this.clienteDao = new ClienteJpaDAO();
        rd = new Random();
    }

    @After
    public void end() throws DAOException {
        Collection<ClienteJpa> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}