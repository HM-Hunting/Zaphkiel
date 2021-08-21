package ink.ptms.zaphkiel.module.meta

import org.bukkit.entity.Player
import taboolib.common.util.asList
import taboolib.library.configuration.ConfigurationSection
import taboolib.module.nms.ItemTag
import taboolib.module.nms.ItemTagList

@MetaKey("can-place-on")
class MetaCanPlaceOn(root: ConfigurationSection) : Meta(root) {

    val canPlaceOn = root.get("meta.can-place-on")?.asList()

    override fun build(player: Player?, compound: ItemTag) {
        if (canPlaceOn == null || compound.containsKey("CanPlaceOn")) {
            return
        }
        compound.putDeep("CanPlaceOn", ItemTagList.of(*canPlaceOn.toTypedArray()))
    }

    override fun drop(player: Player?, compound: ItemTag) {
        compound.remove("CanPlaceOn")
    }

    override fun toString(): String {
        return "MetaCanPlaceOn(canPlaceOn=$canPlaceOn)"
    }
}