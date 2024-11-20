public class VendaJpaDAOTest {
    private IVendaJpaDAO vendaDao;
    private IVendaJpaDAO vendaExclusaoDao;
    private IClienteJpaDAO clienteDao;
    private IProdutoJpaDAO produtoDao;
    private Random rd;
    private ClienteJpa cliente;
    private ProdutoJpa produto;

    public VendaJpaDAOTest() {
        this.vendaDao = new VendaJpaDAO();
        vendaExclusaoDao = new VendaExclusaoJpaDAO();
        this.clienteDao = new ClienteJpaDAO();
        this.produtoDao = new ProdutoJpaDAO();
    }
}