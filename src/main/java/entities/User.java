package entities;

public class User {
    private Long id;
    private String username;
    private String password;
    private Roles role;

    public User(){}
    public User(String username,String password,Roles role){
        this(username,password);
        this.role = role;
    }
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }
}
