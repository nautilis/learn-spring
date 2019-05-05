package observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: nautilis
 **/
public abstract class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

    protected List<O> observerList;

    public Observable() {
        this.observerList = new CopyOnWriteArrayList<>();
    }

    public void addObserver(O o) {
        this.observerList.add(o);
    }

    public void removeObserver(O o) {
        this.observerList.remove(o);
    }

    public void notifyObservers(A a) {
        for(O o : observerList) {
            o.update((S) this, a);
        }
    }
}
