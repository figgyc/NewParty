package uk.figgyc.newparty;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import java.lang.Thread;


public class NewPartyCommand extends CommandBase{

    @Override
    public String getCommandName() {
        return "np";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/np <player>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0) {
            EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

            // This works
            Thread thread = new Thread(() -> {
                player.sendChatMessage("/p disband");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.sendChatMessage("/p " + args[0]);
            });

            thread.start();
        } else {
            throw new WrongUsageException(getCommandUsage(sender));
        }
    }
}
