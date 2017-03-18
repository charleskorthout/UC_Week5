package calculate;
import java.util.Observable;

/**
 * Console observer to enable printing of Edge information using the Observer/Observable pattern
 */
public class ConsoleObserver implements java.util.Observer{
    @Override
    public void update(Observable o, Object arg) {
        Edge e = (Edge)arg;
        System.out.print(e.toString());
    }
}
