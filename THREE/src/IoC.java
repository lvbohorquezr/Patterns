/*Dependency Injection and Inversion of Control
We don't wanted to have any problems with the setup with a framework like
spring, so for that reason we decided to implemented like this, with
a little bit of Inversion of Control :)
*/

/*
In this case, we're going to use a DB (we call MySql because yolo) and all
that we wanna do is try to pass data. In order to Dep.Inj.
 */

import org.jetbrains.annotations.Contract;

/*
In resume, Dep.Inj. means we're passing a dependent object as a parameter
to a method, rather than having the method create the dependent object as a
parameter to a method, rather than having the method create the dependent object
 */

public class IoC {

    public static void main(String[] args) {
        IoC container = new IoC();
        User user = container.new User(container.new OracleDatabase());
        user.add("This is some data");

        User user1 = container.new User(container.new MySqlDatabase());
        user1.add("This is other data");

        User Ucris = container.new User(container.new MySqlDatabase());
        Ucris.add("This is other data");
        
        User user2 = container.new User(container.new OpenDatabase());
        user2.add("This is other data");
        

    }

    public class User {
       Database database;

        /*This is the wrong way, instance a method like an old school because
        you're trying to handle a direct dependency on a particular implementation
        */
//        public User(){
//            database = new MySqlDatabase();
//        }

        /*
        It just gonna has somebody else do't for it and they're gonna
        pass it into my method...It will be feel free, because it'll use the instance
        of db that wa given to it
         */

        public User(Database database){
            this.database = database;
        }

        public void add(String data){
            database.persist(data);
        }
    }
    
    /* Dependency Inversoin Principle: we must rely on abstractions rather than concrete implementations */ 

    public interface Database{
        void persist(String data);
    }

    public class MySqlDatabase implements Database{
        public void persist(String data){
            System.out.println("Mysql has persisted: " + data);
        }
    }

    public class OracleDatabase implements Database{
        public void persist(String data){
            System.out.println("Oracle has persisted: " + data);
        }
    }
  
    public class IBM_Database implements Database{
        public void persist(String data){
            System.out.println("IBM has persisted: " + data)

    
    public class OpenDatabase implements Database{
        public void persist(String data){
            System.out.println("OpenDB has persisted: " + data);

        }
    }
}
