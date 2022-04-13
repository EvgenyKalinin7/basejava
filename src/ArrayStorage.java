/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < firstNullId(storage); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if (searchElementId(storage, r.uuid) > -1) {
            System.out.println("Such element is already exists");
        } else {
            storage[firstNullId(storage)] = r;
        }
    }

    Resume get(String uuid) {
        if (searchElementId(storage, uuid) > -1) {
            return storage[searchElementId(storage, uuid)];
        }
        return null;
    }

    void delete(String uuid) {
        if (searchElementId(storage, uuid) > -1) {
            for (int i = searchElementId(storage, uuid); i < firstNullId(storage); i++) {
                storage[i] = storage[i + 1];
            }
        } else {
            System.out.println("Element is out");
        }
    }

    Resume[] getAll() {
        Resume[] resumeStorage = new Resume[firstNullId(storage)];
        for (int i = 0; i < firstNullId(storage); i++) {
            resumeStorage[i] = storage[i];
        }
        return resumeStorage;
    }

    int size() {
        return firstNullId(storage);
    }

    private int firstNullId(Resume[] storage) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return storage.length - 1;
    }

    private int searchElementId(Resume[] storage, String uuid) {
        for (int i = 0; i < firstNullId(storage); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
