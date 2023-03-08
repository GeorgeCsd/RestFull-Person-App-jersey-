package org.example;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Path("/book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRestService implements BookService {

    private static Map<String,Book> books = new HashMap<String,Book>();
    @Override
    @POST
    @Path("/add")
    public Response addBook(Book b) {
        Response response = new Response();
        if(books.get(b.getId()) != null){
            response.setStatus(false);
            response.setMessage("org.example.Person Already Exists");
            return response;
        }
        books.put(b.getId(), b);
        response.setStatus(true);
        response.setMessage("org.example.Person created successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/delete")
    public Response deleteBook(String id) {
        Response response = new Response();
        if(books.get(id) == null){
            response.setStatus(false);
            response.setMessage("org.example.Person Doesn't Exists");
            return response;
        }
        books.remove(id);
        response.setStatus(true);
        response.setMessage("org.example.Person deleted successfully");
        return response;
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Book getBook(String id) {
        return books.get(id);
    }

    @Override
    @GET
    @Path("/getAll")
    public Book[] getAllBooks() {
        Set<String> ids = books.keySet();
        Book[] b = new Book[ids.size()];
        int i=0;
        for(String id : ids){
            b[i] = books.get(id);
            i++;
        }
        return b;
    }
}
