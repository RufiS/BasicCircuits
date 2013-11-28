package org.tal.basiccircuits;

import org.bukkit.command.CommandSender;
import org.tal.redstonechips.circuit.Circuit;
import org.tal.redstonechips.bitset.BitSet7;
import org.tal.redstonechips.bitset.BitSetUtils;

/**
 *
 * @author Tal Eisenberg
 */
public class decoder extends Circuit {
    BitSet7 register;

    @Override
    public void inputChange(int inIdx, boolean on) {
        if (inIdx==0 && on) {
            int i = BitSetUtils.bitSetToUnsignedInt(inputBits, 1, inputs.length-1);
            register.clear();
            register.set(i);
            this.sendBitSet(0, outputs.length, register);
        }
    }

    @Override
    protected boolean init(CommandSender sender, String[] args) {
        if (inputs.length<2) {
            error(sender, "Expecting at least 2 inputs.");
            return false;
        }
        if (outputs.length>Math.pow(2, inputs.length-1)) {
            error(sender, "Bad number of outputs. Expecting up to " + (int)Math.pow(2, inputs.length-1) + " outputs for " + inputs.length + " inputs.");
            return false;
        }

        register = new BitSet7(outputs.length);
        return true;
    }

}
