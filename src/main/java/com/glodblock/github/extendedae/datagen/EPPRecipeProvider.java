package com.glodblock.github.extendedae.datagen;

import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.AEParts;
import appeng.datagen.providers.tags.ConventionTags;
import com.glodblock.github.extendedae.ExtendedAE;
import com.glodblock.github.extendedae.common.EPPItemAndBlock;
import com.glodblock.github.glodium.datagen.NBTRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class EPPRecipeProvider extends RecipeProvider {

    static String C = "has_item";

    public EPPRecipeProvider(PackOutput p) {
        super(p);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> c) {
        // Extended Parttern Provider
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_PATTERN_PROVIDER)
                .pattern("PC")
                .pattern("CZ")
                .define('P', ConventionTags.PATTERN_PROVIDER)
                .define('C', AEItems.CAPACITY_CARD)
                .define('Z', AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.EX_PATTERN_PROVIDER))
                .save(c, ExtendedAE.id("epp"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EPPItemAndBlock.EX_PATTERN_PROVIDER_PART)
                .requires(EPPItemAndBlock.EX_PATTERN_PROVIDER)
                .unlockedBy(C, has(EPPItemAndBlock.EX_PATTERN_PROVIDER_PART))
                .save(c, ExtendedAE.id("epp_part"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EPPItemAndBlock.EX_PATTERN_PROVIDER)
                .requires(EPPItemAndBlock.EX_PATTERN_PROVIDER_PART)
                .unlockedBy(C, has(EPPItemAndBlock.EX_PATTERN_PROVIDER))
                .save(c, ExtendedAE.id("epp_alt"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EPPItemAndBlock.PATTERN_PROVIDER_UPGRADE)
                .requires(AEItems.CAPACITY_CARD, 2)
                .requires(AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.PATTERN_PROVIDER_UPGRADE))
                .save(c, ExtendedAE.id("epp_upgrade"));

        // Extended Interface
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_INTERFACE)
                .pattern("PC")
                .pattern("CZ")
                .define('P', ConventionTags.INTERFACE)
                .define('C', AEItems.CAPACITY_CARD)
                .define('Z', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.EX_INTERFACE))
                .save(c, ExtendedAE.id("ei"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EPPItemAndBlock.EX_INTERFACE_PART)
                .requires(EPPItemAndBlock.EX_INTERFACE)
                .unlockedBy(C, has(EPPItemAndBlock.EX_INTERFACE_PART))
                .save(c, ExtendedAE.id("ei_part"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EPPItemAndBlock.EX_INTERFACE)
                .requires(EPPItemAndBlock.EX_INTERFACE_PART)
                .unlockedBy(C, has(EPPItemAndBlock.EX_INTERFACE))
                .save(c, ExtendedAE.id("ei_alt"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EPPItemAndBlock.INTERFACE_UPGRADE)
                .requires(AEItems.CAPACITY_CARD, 2)
                .requires(AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.INTERFACE_UPGRADE))
                .save(c, ExtendedAE.id("ei_upgrade"));

        // Infinity Cell
        NBTRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.INFINITY_CELL.getRecordCell(AEFluidKey.of(Fluids.WATER)))
                .pattern("CWC")
                .pattern("WXW")
                .pattern("III")
                .define('C', AEBlocks.QUARTZ_GLASS)
                .define('W', Items.WATER_BUCKET)
                .define('X', AEItems.CELL_COMPONENT_16K)
                .define('I', ConventionTags.DIAMOND)
                .unlockedBy(C, has(EPPItemAndBlock.INFINITY_CELL))
                .save(c, ExtendedAE.id("water_cell"));
        NBTRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.INFINITY_CELL.getRecordCell(AEItemKey.of(Blocks.COBBLESTONE)))
                .pattern("CLC")
                .pattern("WXW")
                .pattern("III")
                .define('C', AEBlocks.QUARTZ_GLASS)
                .define('L', Items.LAVA_BUCKET)
                .define('W', Items.WATER_BUCKET)
                .define('X', AEItems.CELL_COMPONENT_16K)
                .define('I', ConventionTags.DIAMOND)
                .unlockedBy(C, has(EPPItemAndBlock.INFINITY_CELL))
                .save(c, ExtendedAE.id("cobblestone_cell"));

        // Extended IO Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_EXPORT_BUS)
                .pattern("PS")
                .pattern("SZ")
                .define('P', AEParts.EXPORT_BUS)
                .define('S', AEItems.SPEED_CARD)
                .define('Z', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.EX_EXPORT_BUS))
                .save(c, ExtendedAE.id("ebus_out"));
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_IMPORT_BUS)
                .pattern("PS")
                .pattern("SZ")
                .define('P', AEParts.IMPORT_BUS)
                .define('S', AEItems.SPEED_CARD)
                .define('Z', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.EX_IMPORT_BUS))
                .save(c, ExtendedAE.id("ebus_in"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, EPPItemAndBlock.IO_BUS_UPGRADE)
                .requires(AEItems.SPEED_CARD, 2)
                .requires(AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.IO_BUS_UPGRADE))
                .save(c, ExtendedAE.id("ebus_upgrade"));

        // Extended Pattern Access Terminal
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_PATTERN_TERMINAL)
                .pattern(" L ")
                .pattern("CPC")
                .pattern(" C ")
                .define('L', Blocks.REDSTONE_LAMP)
                .define('P', AEParts.PATTERN_ACCESS_TERMINAL)
                .define('C', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.EX_PATTERN_TERMINAL))
                .save(c, ExtendedAE.id("epa"));
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.PATTERN_UPGRADE)
                .pattern(" L ")
                .pattern("CCC")
                .define('L', Blocks.REDSTONE_LAMP)
                .define('C', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.PATTERN_UPGRADE))
                .save(c, ExtendedAE.id("epa_upgrade"));

        // ME Packing Tape
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.PACKING_TAPE)
                .pattern("FG ")
                .pattern("PIP")
                .pattern(" GF")
                .define('I', ConventionTags.IRON_INGOT)
                .define('P', Items.PAPER)
                .define('G', Items.SLIME_BALL)
                .define('F', ConventionTags.FLUIX_DUST)
                .unlockedBy(C, has(EPPItemAndBlock.PACKING_TAPE))
                .save(c, ExtendedAE.id("tape"));

        // Wireless Connector
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.WIRELESS_CONNECTOR, 2)
                .pattern("DWD")
                .pattern("CEC")
                .pattern("DWD")
                .define('D', AEItems.SKY_DUST)
                .define('W', AEItems.WIRELESS_RECEIVER)
                .define('C', ConventionTags.SMART_CABLE)
                .define('E', AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.WIRELESS_CONNECTOR))
                .save(c, ExtendedAE.id("wireless_connector"));

        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.WIRELESS_TOOL)
                .pattern(" W ")
                .pattern("ICI")
                .pattern(" I ")
                .define('I', ConventionTags.IRON_INGOT)
                .define('W', AEItems.WIRELESS_RECEIVER)
                .define('C', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.WIRELESS_TOOL))
                .save(c, ExtendedAE.id("wireless_tool"));

        // Ingredient Buffer
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.INGREDIENT_BUFFER)
                .pattern("IKI")
                .pattern("G G")
                .pattern("IKI")
                .define('I', ConventionTags.IRON_INGOT)
                .define('K', AEItems.CELL_COMPONENT_1K)
                .define('G', AEBlocks.QUARTZ_GLASS)
                .unlockedBy(C, has(EPPItemAndBlock.INGREDIENT_BUFFER))
                .save(c, ExtendedAE.id("ingredient_buffer"));

        // Extended ME Drive
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_DRIVE)
                .pattern("CDC")
                .pattern("FEF")
                .define('C', ConventionTags.GLASS_CABLE)
                .define('D', AEBlocks.DRIVE)
                .define('F', ConventionTags.FLUIX_DUST)
                .define('E', AEItems.CAPACITY_CARD)
                .unlockedBy(C, has(EPPItemAndBlock.EX_DRIVE))
                .save(c, ExtendedAE.id("ex_drive"));

        // Drive Upgrade
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.DRIVE_UPGRADE)
                .pattern("C C")
                .pattern("FEF")
                .define('C', ConventionTags.GLASS_CABLE)
                .define('F', ConventionTags.FLUIX_DUST)
                .define('E', AEItems.CAPACITY_CARD)
                .unlockedBy(C, has(EPPItemAndBlock.DRIVE_UPGRADE))
                .save(c, ExtendedAE.id("ex_drive_upgrade"));

        // Pattern Modifier
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.PATTERN_MODIFIER)
                .pattern("GPG")
                .pattern(" L ")
                .define('G', ConventionTags.dye(DyeColor.GREEN))
                .define('P', AEItems.BLANK_PATTERN)
                .define('L', AEItems.LOGIC_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.PATTERN_MODIFIER))
                .save(c, ExtendedAE.id("pattern_modifier"));

        // Extended Molecular Assembler
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_ASSEMBLER)
                .pattern("FAF")
                .pattern("AEA")
                .pattern("FAF")
                .define('F', ConventionTags.FLUIX_CRYSTAL)
                .define('A', AEBlocks.MOLECULAR_ASSEMBLER)
                .define('E', AEItems.ENGINEERING_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.EX_ASSEMBLER))
                .save(c, ExtendedAE.id("ex_molecular_assembler"));

        // Extended Inscriber
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_INSCRIBER)
                .pattern("FAF")
                .pattern("AEA")
                .pattern("FAF")
                .define('F', AEBlocks.INSCRIBER)
                .define('A', AEParts.STORAGE_BUS)
                .define('E', ConventionTags.INTERFACE)
                .unlockedBy(C, has(EPPItemAndBlock.EX_INSCRIBER))
                .save(c, ExtendedAE.id("ex_inscriber"));

        // Extended Charger
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.EX_CHARGER)
                .pattern("FAF")
                .pattern("AEA")
                .pattern("FAF")
                .define('F', AEBlocks.CHARGER)
                .define('A', AEParts.STORAGE_BUS)
                .define('E', ConventionTags.INTERFACE)
                .unlockedBy(C, has(EPPItemAndBlock.EX_CHARGER))
                .save(c, ExtendedAE.id("ex_charger"));

        // Tag Storage Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.TAG_STORAGE_BUS)
                .pattern(" L ")
                .pattern("RBR")
                .pattern(" K ")
                .define('L', AEItems.LOGIC_PROCESSOR)
                .define('R', ConventionTags.REDSTONE)
                .define('B', AEParts.STORAGE_BUS)
                .define('K', Items.BOOK)
                .unlockedBy(C, has(EPPItemAndBlock.TAG_STORAGE_BUS))
                .save(c, ExtendedAE.id("tag_storage_bus"));

        // Tag Export Bus
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.TAG_EXPORT_BUS)
                .pattern(" L ")
                .pattern("RBR")
                .pattern(" K ")
                .define('L', AEItems.LOGIC_PROCESSOR)
                .define('R', ConventionTags.REDSTONE)
                .define('B', AEParts.EXPORT_BUS)
                .define('K', Items.BOOK)
                .unlockedBy(C, has(EPPItemAndBlock.TAG_EXPORT_BUS))
                .save(c, ExtendedAE.id("tag_export_bus"));

        // Threshold Level Emitter
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.THRESHOLD_LEVEL_EMITTER)
                .pattern("RER")
                .pattern(" C ")
                .define('R', Items.REDSTONE_TORCH)
                .define('E', AEParts.LEVEL_EMITTER)
                .define('C', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(C, has(EPPItemAndBlock.THRESHOLD_LEVEL_EMITTER))
                .save(c, ExtendedAE.id("threshold_level_emitter"));

        // Fishbig
        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, EPPItemAndBlock.FISHBIG)
                .pattern("FFF")
                .pattern("F F")
                .pattern("FFF")
                .define('F', Items.PUFFERFISH)
                .unlockedBy(C, has(EPPItemAndBlock.FISHBIG))
                .save(c, ExtendedAE.id("fishbig"));

    }
}
