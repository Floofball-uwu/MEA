package farmerthanos.mea;

import arc.Events;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class MEA extends Mod{

    public MEA() {
        Announcements.load();

        Events.on(EventType.DisposeEvent.class, e -> {
            Announcements.dispose();
        });
    }

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
        new Announcements().load();
    }
}
