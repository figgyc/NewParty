package uk.figgyc.newparty;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = NewParty.MODID, version = NewParty.VERSION, clientSideOnly = true)
public class NewParty
{
    public static final String MODID = "newparty";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new NewPartyCommand());
    }
}
