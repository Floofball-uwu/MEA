package farmerthanos.mea;

import arc.func.Cons;
import arc.util.Log;
import mindustry.gen.Building;
import mindustry.gen.Building.*;
import mindustry.gen.Bullet;
import mindustry.gen.Groups;
import mindustry.gen.Musics;

import static mindustry.Vars.*;


public class Calls {
    public void load(){
        //I thank megacatswoop#7269 for this
        for (Building build : Groups.build) {
            class Breakable implements Cons<Bullet> {
                public boolean stop = false;

                @Override
                public void get(Bullet bullet) {
                    if (bullet.team != build.team) {
                        Announcements.BaseUnderAttack.play();
                        stop = true;
                    }
                }
            }
            Breakable intersect = new Breakable();

            Groups.bullet.intersect(build.x - (build.block().size / 2) - 10 * 8, build.y - (build.block().size / 2) - 10 * 8, 10 * 8, 10 * 8, intersect);
            if (intersect.stop) break;
        }
    }
}
