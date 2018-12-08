package StrawberrySpireMod.relics;

import com.badlogic.gdx.graphics.*;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.relics.*;

import basemod.abstracts.*;

public class TannedGloves extends CustomRelic {

    public static final String ID = "strawberrySpire:TannedGloves";
    public static final Texture IMAGE_PATH = new Texture("relics/placeholder.png");
    private static final int EXHAUST_AMOUNT = 6;

    public TannedGloves() {
        super(ID, IMAGE_PATH, RelicTier.SPECIAL, LandingSound.FLAT);
        this.counter = 0;
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + EXHAUST_AMOUNT + DESCRIPTIONS[1];
    }

    public void onExhaust(AbstractCard card) {
        this.counter++;
        if (this.counter % EXHAUST_AMOUNT == 0) {
            this.counter = 0;
            flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(1));
        }
    }

    public AbstractRelic makeCopy() {
        return new TannedGloves();
    }
}