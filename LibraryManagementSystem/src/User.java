public class User {
    private int userid;
    private String username;
    void setUserid(int id){
        this.userid = id;
    }
    void setUsername(String name){
        this.username = name;
    }
    int getUserid(){
        return userid;
    }
    String getUsername(){
        return username;
    }
}
