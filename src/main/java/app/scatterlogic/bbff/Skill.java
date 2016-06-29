package app.scatterlogic.bbff;

/**
 * Created by Robin on 22/06/2016.
 */
public class Skill {
    private String name;
    private String type;
    private String text;


    public Skill (String skillName){
        name = skillName;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public boolean relatesTo(String thingQueried){
        String deCaseText = text.toLowerCase();
        String deCaseThingQueried = thingQueried.toLowerCase();
        if (deCaseText.contains(deCaseThingQueried)) {
            return true;
        } else return false;
    }
}
