package Helper;
import static pages.ApiPage.idUser;

public class Endpoint {

    public static final String host_gorest = "https://gorest.co.in/public/v2/";

    public static final String GET_LIST_USERS = host_gorest + "users";
    public static final String CREATE_NEW_USERS = host_gorest + "users";

    public static final String UPDATE_USERS = host_gorest + "users/"+ idUser;
   //  public static final String DELETE_USER = host_gorest + "users/"+ id;


}
