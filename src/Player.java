public class Player {
    private String name;

    public Player(String name){
        this.name = name;
    }

    public Player(){
        this("Default Player");
    }

    public String getName(){
        return this.name;
    }
}
