package customClassCollection;

public class CustomCollectionExceptions extends Exception {

    private int index;

    CustomCollectionExceptions(int index){
        this.index = index;
    }

    @Override
    public String toString(){
        return "EXCEPTION! " + "Индекс: " + index + " за пределами колллекции." ;
    }
}
