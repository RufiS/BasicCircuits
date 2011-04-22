
package org.tal.basiccircuits;

import org.tal.redstonechips.circuit.BitSetCircuit;
import org.tal.redstonechips.util.BitSet7;

/**
 *
 * @author Tal Eisenberg
 */
public class xnor extends BitSetCircuit {

    @Override
    protected void bitSetChanged(int bitSetIdx, BitSet7 set) {
        BitSet7 out = (BitSet7)inputBitSets[0].clone();
        for (int i=1; i<this.inputBitSets.length; i++) {
            out.xor(inputBitSets[i]);
        }
        
        out.flip(0, wordlength);
        this.sendBitSet(out);
    }

}
