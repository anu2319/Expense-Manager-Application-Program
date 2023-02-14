import java.util.HashMap;

public class User
{
    String user_name;
    String password;
    static HashMap<String,User>signed_up_users = new HashMap<>();
    HashMap<String,Group> user_groups = new HashMap<>();
    User current_login_user ;

    public void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void sign_up()
    {
        signed_up_users.put(user_name,this);
        System.out.println("Account Created Successfully");
    }

    public void login(String user_name, String password)
    {
        for (String key : signed_up_users.keySet())
        {
            if(key.equals(user_name) && signed_up_users.get(key).password.equals(password))
            {
                if(current_login_user==null)
                {
                    current_login_user = this;
                    System.out.println("Welcome ! " +user_name+" "+"logged in successfully");
                }
                else
                {
                    System.out.println("User already logged in. Please logout and try again");
                }
            }
        }
    }

    public void logout()
    {
        if(current_login_user==null)
        {
            System.out.println("No User to Logout");
        }
        else
        {
            signed_up_users.remove(this.user_name);
            System.out.println("Logout Successfully");
        }
    }

}
