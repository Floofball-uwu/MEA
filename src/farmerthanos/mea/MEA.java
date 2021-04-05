package farmerthanos.mea;

import arc.Events;
import arc.util.Log;
import farmerthanos.mea.calls.BaseUnderAttack;
import farmerthanos.mea.calls.CoreUnderAttack;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;

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
        new BaseUnderAttack().load();
        new CoreUnderAttack().load();
        Log.info("MEA online");
    }
}
