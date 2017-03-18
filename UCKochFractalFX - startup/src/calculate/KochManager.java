package calculate;
import java.util.*;
import uckochfractalfx.UCKochFractalFX;

import java.util.Observer;

/**
 * Created by Charles Korthout on 3/17/2017.
 */
public class KochManager implements Observer {
    private UCKochFractalFX application;
    private KochFractal koch = null;

    public KochManager(UCKochFractalFX application) {
        this.application = application;
        koch = new KochFractal();
        koch.addObserver(this);
        koch.setLevel(1);
    }

    public void changeLevel(int nxt) {
        koch.setLevel(nxt);
        drawEdges();
    }

    public void drawEdges() {
        application.clearKochPanel();
        koch.generateLeftEdge();
        koch.generateBottomEdge();
        koch.generateRightEdge();
    }

    @Override
    public void update(Observable o, Object arg) {
        application.drawEdge((Edge)arg);
    }


}
