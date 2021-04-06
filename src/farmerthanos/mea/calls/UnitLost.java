package farmerthanos.mea.calls;

import arc.util.Interval;
import arc.util.Timer;
import mindustry.gen.Unit;

import static mindustry.Vars.*;

public class UnitLost {
    public static void load() {
        Interval interval = new Interval(1);
        Timer.schedule(() -> {}, 0f, 0.01f);
    }
}
