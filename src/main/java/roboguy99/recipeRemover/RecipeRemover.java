package roboguy99.recipeRemover;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid="RecipeRemover", name="Recipe Remover", version="1.1.0", acceptableRemoteVersions = "*")
public class RecipeRemover
{
    Configuration config;
    private static final String[] DEFAULT_RECIPE_LIST = {"minecraft:stone", "modid:item"};
    private String[] recipeList;
    public static final Logger logger = LogManager.getLogger("RecipeRemover");
  
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    	logger.info("Loading config");
	  
    	Configuration config = new Configuration(e.getSuggestedConfigurationFile());
    
    	config.load();
    		Property recipeList = config.get(Configuration.CATEGORY_GENERAL, "disabledRecipes", DEFAULT_RECIPE_LIST);
    		String[] recipeListS = recipeList.getStringList();
    		recipeList.comment = "Place the block ID on each separate line. \n Use the /id command in-game to get the block/item IDs.";
		config.save();
    
		this.recipeList = recipeListS;
		
		logger.info("Config loaded successfully");
    }
  
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	System.out.println("[RecipeRemover] Removing recipes");
    	
    	for(int i = 0; i < this.recipeList.length; i++)
        {
        	  this.removeRecipes(this.recipeList[i]);
        }
    	
    	logger.info("Recipes removed succesfully");
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
      event.registerServerCommand(new FindIDCommand());
      event.registerServerCommand(new FindIDFromHandCommand());
    }
  

    @SuppressWarnings("unchecked")
    private void removeRecipes(String toDelete)
    {    
    	ItemStack resultItem = new ItemStack((Item)Item.itemRegistry.getObject(toDelete));
    	if (resultItem != null)
		{
    		resultItem.stackSize = 1;
		}
    	
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
       
		for (int i = 0; i < recipes.size(); i++)
        {
            IRecipe tmpRecipe = recipes.get(i);
            ItemStack recipeResult = tmpRecipe.getRecipeOutput();
            if(recipeResult != null) 
            {
            	recipeResult.stackSize = 1;
            }
            
            if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
            {
                recipes.remove(i--);
            }
        }
    }
}
