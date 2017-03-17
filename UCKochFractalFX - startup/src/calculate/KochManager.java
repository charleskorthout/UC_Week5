package calculate;
import javafx.beans.Observable;
import uckochfractalfx.UCKochFractalFX;

import java.util.Observer;

/**
 * Created by Charles Korthout on 3/17/2017.
 */
public class KochManager extends Observer {
    private UCKochFractalFX application;
    public KochManager(UCKochFractalFX application) {
        this.application = application;
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
    public void update (Observable o, Object arg) {
        application.drawEdge((Edge)arg);

    }
}
