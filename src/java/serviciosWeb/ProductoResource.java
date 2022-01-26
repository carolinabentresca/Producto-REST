
package serviciosWeb;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import modelo.Producto;
import modelo.ProductoDao;


@Path("producto")
public class ProductoResource {

    @Context
    private UriInfo context;
    ProductoDao dao = new ProductoDao();
    
    public ProductoResource() {
    }

    //Listar Productos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listarProductos() {
        List<Producto> lista = dao.listar();
        return lista;
      
    }
    
    //Registrar Producto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Producto registrarProducto(Producto pro) {
        dao.registrar(pro);
        return pro;
    }
}
