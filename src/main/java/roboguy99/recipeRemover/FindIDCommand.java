package roboguy99.recipeRemover;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class FindIDCommand implements ICommand
{
	private List<String> aliases;
	
	public FindIDCommand()
	{
		this.aliases = new ArrayList<String>();
		this.aliases.add("id");
		this.aliases.add("findID");
	}
	
	@Override
	public int compareTo(Object arg0)
	{
		return 0;
	}
	
	@Override
	public String getCommandName()
	{
		return "id";
	}
	
	@Override
	public String getCommandUsage(ICommandSender p_71518_1_)
	{
		return EnumChatFormatting.RED + "Returns the textual ID when given a number ID: " + EnumChatFormatting.AQUA + "id <number ID>";
	}
	
	@Override
	public List<?> getCommandAliases()
	{
		return this.aliases;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] input)
	{
		if(input.length != 0)
		{
			try
			{
				int id = Integer.parseInt(input[0]);
				String name = Item.itemRegistry.getNameForObject(Item.itemRegistry.getObjectById(id));
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Item textual ID: " + EnumChatFormatting.AQUA + name));
			}
			catch(NumberFormatException e)
			{
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "Please enter a valid number ID"));
				return;
			}
		}
		else
		{
			sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "Please enter a valid number ID"));
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		return true;
	}
	
	@Override
	public List<?> addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_)
	{
		return null;
	}
	
	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_)
	{
		return false;
	}
	
}
