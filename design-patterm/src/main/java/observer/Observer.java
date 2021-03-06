package observer;

public interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A> , A> {

    void update(S s, A a);
}
