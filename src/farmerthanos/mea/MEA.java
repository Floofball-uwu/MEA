package farmerthanos.mea;

import arc.Events;
import arc.util.Log;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.mod.Mods;

public class MEA extends Mod{

    public MEA() {
        if(Vars.headless) {
            Events.on(EventType.FileTreeInitEvent.class, e -> {
                Announcements.load();
            });
        } else {
            Announcements.load();
        }
    }

    @Override
    public void init(){
        new Calls().load();
        Log.info("MEA online");
    }
}
