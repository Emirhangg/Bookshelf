package net.darkhax.bookshelf.asm;

import net.darkhax.bookshelf.asm.transformers.*;
import net.minecraft.launchwrapper.IClassTransformer;

public class BookshelfTransformerManager implements IClassTransformer {
    
    @Override
    public byte[] transform (String name, String transformedName, byte[] classBytes) {
        
        if (transformedName.equals("net.minecraft.entity.passive.EntityHorse"))
            return EntityHorseTransformer.transform(name, transformedName, classBytes);
            
        if (transformedName.equals("net.minecraft.inventory.ContainerEnchantment"))
            return ContainerEnchantmentTransformer.transform(name, transformedName, classBytes);
            
        if (transformedName.equals("net.minecraft.item.Item") || transformedName.equals("net.minecraft.item.ItemArmor"))
            return ItemColorTransformer.transform(name, transformedName, classBytes);
            
        if (transformedName.equals("net.minecraft.enchantment.EnchantmentHelper"))
            return EnchantmentHelperTransformer.transform(name, transformedName, classBytes);
            
        if (transformedName.equals("net.minecraft.creativetab.CreativeTabs"))
            return CreativeTabsTransformer.transform(name, transformedName, classBytes);
            
        return classBytes;
    }
}
