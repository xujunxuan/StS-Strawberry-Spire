package StrawberrySpireMod.powers;

import com.megacrit.cardcrawl.actions.unique.*;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.powers.*;

public class NeuronsPower extends AbstractStrawberrySpirePower {

    public static final String POWER_ID = "strawberrySpire:Neurons";
    private static final PowerStrings POWER_STRINGS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = POWER_STRINGS.NAME;
    public static final String[] DESCRIPTIONS = POWER_STRINGS.DESCRIPTIONS;

    public NeuronsPower(AbstractCreature owner) {
        this.ID = POWER_ID;
        this.name = NAME;
        this.type = AbstractPower.PowerType.BUFF;
        this.owner = owner;
        updateDescription();
        loadRegion("wraithForm");
        this.priority = 50;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    public void atStartOfTurnPostDraw() {
        flash();
        AbstractDungeon.actionManager.addToBottom(new EnlightenmentAction(true));
    }
}
