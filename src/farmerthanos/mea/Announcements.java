package farmerthanos.mea;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.MusicLoader;
import arc.audio.Music;
import mindustry.Vars;

public class Announcements {
    protected static Music loadMusic(String musicName) {
        if (!Vars.headless) {
            String name = "music/" + musicName;
            String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

            Music music = new Music();

            AssetDescriptor<?> desc = Core.assets.load(path, Music.class, new MusicLoader.MusicParameter(music));
            desc.errored = Throwable::printStackTrace;

            return music;
        } else {
            return new Music();
        }
    }

    protected static Music disposeMusic(String musicName) {
        if (!Vars.headless) {
            String name = "music/" + musicName;
            String path = name + ".ogg";

            if (Core.assets.isLoaded(path, Music.class)) {
                Core.assets.unload(path);
            }
        }

        return null;
    }

    public static Music
    BaseUnderAttack, CoreUnderAttack, LowPower, MonoUnderAttack, Resources, SectorCaptured, UnitLost;

    public static void load() {

        BaseUnderAttack = loadMusic("BaseUnderAttack");
        CoreUnderAttack = loadMusic("CoreUnderAttack");
        LowPower = loadMusic("LowPower");
        MonoUnderAttack = loadMusic("MonoUnderAttack");
        Resources = loadMusic("Resources");
        SectorCaptured = loadMusic("SectorCaptured");
        UnitLost = loadMusic("UnitLost");
    }

    public static void dispose() {

        BaseUnderAttack = disposeMusic("BaseUnderAttack");
        CoreUnderAttack = disposeMusic("CoreUnderAttack");
        LowPower = disposeMusic("LowPower");
        MonoUnderAttack = disposeMusic("MonoUnderAttack");
        Resources = disposeMusic("Resources");
        SectorCaptured = disposeMusic("SectorCaptured");
        UnitLost = disposeMusic("UnitLost");
    }
}
