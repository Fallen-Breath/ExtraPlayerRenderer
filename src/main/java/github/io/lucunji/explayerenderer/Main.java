package github.io.lucunji.explayerenderer;

import fi.dy.masa.malilib.config.ConfigManager;
import github.io.lucunji.explayerenderer.config.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.impl.client.keybinding.KeyBindingRegistryImpl;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer{

    public static final String MOD_ID = "explayerenderer";

    public static final KeyBinding MASTER_CONTROL = new KeyBinding(MOD_ID + ":master_control",
            InputUtil.Type.KEYSYM,
            InputUtil.fromName("key.keyboard.f7").getKeyCode(),
            "key.categories.ui");

    @Override
    public void onInitialize(){
        ConfigManager.getInstance().registerConfigHandler(MOD_ID, new ConfigHandler());
        new Configs();
        ConfigHandler.loadFile();
        KeyBindingRegistryImpl.registerKeyBinding(MASTER_CONTROL);
        ClientTickEvents.START_CLIENT_TICK.register(new KeyBindHandler());
    }
}
