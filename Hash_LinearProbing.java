public class Hash_LinearProbing {
    // HashTable -> 배열로 할당이 되어 있다.
    public Slot[] hashTable;

    public Hash_LinearProbing(Integer size) {
        this.hashTable = new Slot[size];  // 미리 사이즈 할당
    }

    public class Slot {
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // 해시 함수 구현
    public Integer hashFunction(String key) {
        return (int)(key.charAt(0) % this.hashTable.length);
    }

    // 저장을 성공했는가
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunction(key);

        // 해당 주소에 이미 데이터가 존재할 경우
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;


                while(this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        // 인덱스를 현재 인덱스에서 뒤쪽 인덱스로만 검색하므로
                        // 실제로 비어있는 Slot이 존재하지만 false를 반환할 수도 있음
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunction(key);

        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address + 1;

                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
            return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

        Hash_LinearProbing myHash = new Hash_LinearProbing(20);

        myHash.saveData("MinjuKang","01075043700");
        myHash.saveData("Lees","01098251090");
        myHash.saveData("James","01044444180");
        myHash.saveData("Daves","01012347180");
        myHash.saveData("Dalyes","01099999999");
                                                          // Output
        System.out.println(myHash.getData("Lees"));       // 01095251090
        System.out.println(myHash.getData("James"));      // 01044444180
        System.out.println(myHash.getData("MinjuKang"));  // 01075043700
        System.out.println(myHash.getData("Daves"));      // 01012347180
        System.out.println(myHash.getData("Dalyes"));     // 01099999999
        System.out.println(myHash.getData("Doolly"));     // null

    }
}
