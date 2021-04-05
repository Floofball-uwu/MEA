package farmerthanos.mea.calls;


import arc.Events;
import arc.func.Cons;
import arc.util.Interval;
import arc.util.Log;
import arc.util.Timer;
import farmerthanos.mea.Announcements;
import mindustry.game.EventType.*;

public class CoreUnderAttack {
    public static void load() {
        Timer.schedule(() -> {
            Interval interval = new Interval(1);
            Events.run(Trigger.teamCoreDamage, () -> {
                if (interval.get(0, 60 * 10)) {
                    Announcements.CoreUnderAttack.play();
                }
            });
        }, 0f);
    }
}
