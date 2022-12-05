

public abstract class item {

    protected String name;
    protected int CPS; // количестко кликов от 1 предмета в сек
    protected double cost;
    protected double multicost;//кооф умножения цены
    protected String icon;

    public int returnCPS(){
        return CPS;
    }

}
