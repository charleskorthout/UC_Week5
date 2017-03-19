package calculate;
import java.util.*;
import uckochfractalfx.UCKochFractalFX;

import java.util.Observer;
import timeutil.TimeStamp;

/**
 * Created by Charles Korthout on 3/17/2017.
 */
public class KochManager implements Observer {
    private UCKochFractalFX application;
    private KochFractal koch = null;
    // add a list to hold the individual edges (exercise 4)
    private List<Edge> edges = null;

    public KochManager(UCKochFractalFX application) {
        this.application = application;
        edges = new ArrayList();
        koch = new KochFractal();
        koch.addObserver(this);
        koch.setLevel(1);
    }

    public void changeLevel(int nxt) {
        koch.setLevel(nxt);
        drawEdges();
    }

    public void drawEdges() {
        TimeStamp ts = new TimeStamp();
        ts.init();
        ts.setBegin();
        application.clearKochPanel();
        koch.generateLeftEdge();
        koch.generateBottomEdge();
        koch.generateRightEdge();
        edges.stream()
             .forEach(e -> application.drawEdge(e)); // print the individual edges
        ts.setEnd();
        application.setTextCalc(ts.toString());
    }

    @Override
    public void update(Observable o, Object arg) {
        Edge edge = (Edge)arg;
        edges.add(edge); // add the edge to the list
        application.setTextNrEdges(""+edges.size());
    }
}
