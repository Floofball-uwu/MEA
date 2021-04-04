package farmerthanos.mea;

import arc.Events;
import arc.util.Log;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class MEA extends Mod{

    public MEA() {
        Log.info("Did this load with 'hidden: true'?");

        //Evil 'hidden: true' bypass to load stuff
        loadContent();

        Announcements.load();
        if(Vars.headless) {
            Events.on(EventType.FileTreeInitEvent.class, e -> {
                Announcements.load();
            });
        } else {
            Announcements.load();
        }
    }

    @Override
    public void loadContent(){
        new Announcements().load();
        new Calls().load();
        Log.info("MEA online");
    }
}
