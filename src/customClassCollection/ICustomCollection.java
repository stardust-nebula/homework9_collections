package customClassCollection;

public interface ICustomCollection<E> {

    void add(E elem);

    int size();

    E getElementByIndex(int index) throws CustomCollectionExceptions;

    void resize();

    void clearCollection();

    boolean isElementExist(E elem);
}
