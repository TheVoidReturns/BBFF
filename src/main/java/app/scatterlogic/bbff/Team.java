package app.scatterlogic.bbff;

import java.util.List;

/**
 * Created 20/06/2016.
 */
public class Team {
    String name;
    String race;
    long value;
    long treasury;
    Player[] players = new Player[16];
    int rerolls;
    int fanFactor;
    int assistantCoaches;
    int cheerleaders;
    int apothecary;

    List teamMatchHistory;
}
