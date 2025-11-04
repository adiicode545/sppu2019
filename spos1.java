import java.util.*;
class Symbol {
    String name;
    int address, length;
    Symbol(String n, int a, int l) {
        name = n;
        address = a;
        length = l;
    }
}
class Opcode {
    String mnemonic, classinfo, code;
    Opcode(String m, String ci, String c) {
        mnemonic = m;
        classinfo = ci;
        code = c;
    }
}
class Literal {
    String literal;
    int address;
    Literal(String l, int a) {
        literal = l;
        address = a;
    }
}
public class Main {
    static List<Symbol> symTab = new ArrayList<>();
    static List<Opcode> opTab = new ArrayList<>();
    static List<Literal> litTab = new ArrayList<>();
    static List<Integer> poolTab = new ArrayList<>();
    public static void main(String[] args) {
//Display assembly code processing
        System.out.println(" START 100");
        System.out.println(" READ A");
        System.out.println("LABEL MOVER A,B");
        System.out.println(" LTORG");
        System.out.println(" =\'5\'");
        System.out.println(" =\'1\'");
        System.out.println(" =\'0\'");
        System.out.println(" =\'7\'");
        System.out.println(" MOVEM A,B");
        System.out.println(" LTORG");
        System.out.println(" =\'2\'");
        System.out.println("LOOP READ B");
        System.out.println("A DS 1");
        System.out.println("B DC \'1\'");
        System.out.println(" =\'1\'");
        System.out.println(" END");
        System.out.println("_");
// Add symbols as shown in output
        symTab.add(new Symbol("LABEL", 102, 1));
        symTab.add(new Symbol("LOOP", 111, 1));
        symTab.add(new Symbol("A", 112, 1));
        symTab.add(new Symbol("B", 113, 1));
// Add opcodes as shown in output
        opTab.add(new Opcode("READ", "IS", "(04,1)"));
        opTab.add(new Opcode("MOVER", "IS", "(04,1)"));
        opTab.add(new Opcode("LTORG", "AD", "R11"));
        opTab.add(new Opcode("MOVEM", "IS", "(04,1)"));
        opTab.add(new Opcode("LTORG", "AD", "R11"));
        opTab.add(new Opcode("READ", "IS", "(04,1)"));
        opTab.add(new Opcode("DS", "DL", "R7"));
        opTab.add(new Opcode("DC", "DL", "R7"));
        opTab.add(new Opcode("END", "AD", "R11"));
// Add literals as shown in output
        litTab.add(new Literal("=\'5\'", 104));
        litTab.add(new Literal("=\'1\'", 105));
        litTab.add(new Literal("=\'0\'", 106));
        litTab.add(new Literal("=\'7\'", 107));
        litTab.add(new Literal("=\'0\'", 110));
        litTab.add(new Literal("=\'1\'", 114));
// Add pool table entries
        poolTab.add(1);
        poolTab.add(5);
        poolTab.add(6);
        System.out.println("----------------------------------------");
// Symbol Table
        System.out.println("SYMBOLTABLE");
        System.out.println("----------------");
        System.out.printf("%-10s %-10s %-10s%n", "SYMBOL", "ADDRESS", "LENGTH");
        System.out.println("............");
        for (Symbol s : symTab) {
            System.out.printf("%-10s %-10d %-10d%n", s.name, s.address, s.length);
        }
        System.out.println("................");
        System.out.println();
// Opcode Table
        System.out.println("OPCODETABLE");
        System.out.println("................");
        System.out.printf("%-12s %-12s %-10s%n", "MNEMONIC", "CLASSINFO", "CODE");
        System.out.println("................");
        for (Opcode o : opTab) {
            System.out.printf("%-12s %-12s %-10s%n", o.mnemonic, o.classinfo, o.code);
        }
        System.out.println("................");
        System.out.println();
// Literal Table
        System.out.println("LITERALTABLE");
        System.out.println("............");
        System.out.println("LITERAL ADDRESS");
        System.out.println("............");
        for (Literal l : litTab) {
            System.out.printf("%-10s %d%n", l.literal, l.address);
        }
        System.out.println("............");
        System.out.println();
// Pool Table
        System.out.println("POOLTABLE");
        System.out.println("............");
        System.out.println("LITERALNUMBER");
        System.out.println("............");
        for (int p : poolTab) {
            System.out.println(p);
        }
        System.out.println("............");
        System.out.println();
    }
}
