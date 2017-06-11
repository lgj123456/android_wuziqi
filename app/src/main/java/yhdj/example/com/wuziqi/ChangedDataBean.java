package yhdj.example.com.wuziqi;

import java.util.List;

/**
 * Created by yhdj on 2017/6/11.
 */

public class ChangedDataBean {

    /**
     * appKey : 88550df99426c362c26d3ee1151a6bc6
     * tableName : Match
     * objectId : 647cec14f0
     * action : updateRow
     * data : {"createdAt":"2017-06-14 16:42:50","isBegin":false,"mBlackArray":[{"x":4,"y":3},{"x":3,"y":5},{"x":6,"y":4}],"mWhiteArray":[{"x":3,"y":4},{"x":4,"y":4},{"x":4,"y":5},{"x":6,"y":7}],"objectId":"647cec14f0","roomName":"","state":0,"updatedAt":"2017-06-14 16:44:11","username":""}
     */

    private String appKey;
    private String tableName;
    private String objectId;
    private String action;
    /**
     * createdAt : 2017-06-14 16:42:50
     * isBegin : false
     * mBlackArray : [{"x":4,"y":3},{"x":3,"y":5},{"x":6,"y":4}]
     * mWhiteArray : [{"x":3,"y":4},{"x":4,"y":4},{"x":4,"y":5},{"x":6,"y":7}]
     * objectId : 647cec14f0
     * roomName :
     * state : 0
     * updatedAt : 2017-06-14 16:44:11
     * username :
     */

    private DataBean data;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String createdAt;
        private boolean isBegin;
        private String objectId;
        private String roomName;
        private int state;
        private String updatedAt;
        private String username;
        /**
         * x : 4
         * y : 3
         */

        private List<MBlackArrayBean> mBlackArray;
        /**
         * x : 3
         * y : 4
         */

        private List<MWhiteArrayBean> mWhiteArray;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public boolean isIsBegin() {
            return isBegin;
        }

        public void setIsBegin(boolean isBegin) {
            this.isBegin = isBegin;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<MBlackArrayBean> getMBlackArray() {
            return mBlackArray;
        }

        public void setMBlackArray(List<MBlackArrayBean> mBlackArray) {
            this.mBlackArray = mBlackArray;
        }

        public List<MWhiteArrayBean> getMWhiteArray() {
            return mWhiteArray;
        }

        public void setMWhiteArray(List<MWhiteArrayBean> mWhiteArray) {
            this.mWhiteArray = mWhiteArray;
        }

        public static class MBlackArrayBean {
            private int x;
            private int y;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        public static class MWhiteArrayBean {
            private int x;
            private int y;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }
    }
}
