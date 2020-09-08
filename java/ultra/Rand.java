package ultra;
import  java.util.concurrent.ThreadLocalRandom;

public class Rand
{
    static char[] tbl = new char[] {'-','0','1','2','3','4','5','6','7','8',
                                    '9','A','B','C','D','E','F','G','H','I',
                                    'J','K','L','M','N','O','P','Q','R','S',
                                    'T','U','V','W','X','Y','Z','_','a','b',
                                    'c','d','e','f','g','h','i','j','k','l',
                                    'm','n','o','p','q','r','s','t','u','v',
                                    'w','x','y','z'};

    public static String ultraRand() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        long l1 = tlr.nextLong(), l2 = tlr.nextLong();
        char[] rt = new char[22];
        rt[21] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[20] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[19] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[18] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[17] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[16] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[15] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[14] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[13] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[12] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
        rt[11] = tbl[(int)l1 & 0x3f];
        rt[10] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 9] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 8] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 7] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 6] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 5] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 4] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 3] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 2] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 1] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
        rt[ 0] = tbl[(int)l2 & 0x3f];
        return new String(rt);
    }
}
