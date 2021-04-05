package farmerthanos.mea.calls;

import arc.func.Cons;
import arc.util.Interval;
import arc.util.Log;
import arc.util.Timer;
import farmerthanos.mea.Announcements;
import mindustry.gen.*;

import static mindustry.Vars.*;

public class BaseUnderAttack {
    public static void load() {
        //Thank you megacatswoop#7269 for making this code
        //Does not work with walls as they seem to do nothing. :^)
        Interval interval = new Interval(1);
        Timer.schedule(() -> {
            for (Building build : Groups.build) {
                class Breakable implements Cons<Bullet> {
                    public boolean stop = false;

                    @Override
                    public void get(Bullet bullet) {
                        if (bullet.team != build.team && bullet.team != player.team()) {
                            if (interval.get(0, 60 * 120)) {
                                Announcements.BaseUnderAttack.play();
                            }
                            stop = true;
                        }
                    }
                }

                Breakable intersect = new Breakable();

                Groups.bullet.intersect(build.x - (build.block().size / 2) - 10 * 8,
                        build.y - (build.block().size / 2) - 10 * 8,
                        10 * 8, 10 * 8, intersect);
                if (intersect.stop) break;
            }
        }, 0f, 0.4f);
    }
}