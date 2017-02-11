package JavaBean;

import java.util.List;

/**
 * Created by user on 2017/1/21.
 */

public class InjectStation {
    /**
     * help : http://data.kcg.gov.tw/api/3/action/help_show?name=datastore_search
     * success : true
     * result : {"resource_id":"b5d645b6-b7a5-46a3-98b1-993f14dbd1a3","fields":[{"type":"int4","id":"_id"},{"type":"text","id":"機構名稱"},{"type":"text","id":"機構電話"},{"type":"numeric","id":"郵遞區號"},{"type":"text","id":"機構地址"}],"records":[{"機構名稱":"一嘉動物醫院","郵遞區號":"80243","_id":1,"機構地址":"高雄市苓雅區興中一路383號","機構電話":"07-3318123"},{"機構名稱":"人人動物醫院","郵遞區號":"83154","_id":2,"機構地址":"高雄市大寮區鳳林三路827號","機構電話":"07-7830515"},{"機構名稱":"人愛動物醫院","郵遞區號":"80048","_id":3,"機構地址":"高雄市新興區六合一路30號","機構電話":"07-2371276"},{"機構名稱":"十銓動物醫院","郵遞區號":"80752","_id":4,"機構地址":"高雄市三民區十全二路99號","機構電話":"07-3113797"},{"機構名稱":"三和台大動物醫院","郵遞區號":"80253","_id":5,"機構地址":"高雄市苓雅區光華一路23號","機構電話":"07-3383828"},{"機構名稱":"上揚動物醫院","郵遞區號":"80242","_id":6,"機構地址":"高雄市苓雅區林森二路7之2號","機構電話":"07-3391010"},{"機構名稱":"凡賽爾動物醫院","郵遞區號":"83092","_id":7,"機構地址":"高雄市鳳山區五甲二路399號","機構電話":"07-7613995"},{"機構名稱":"大其動物醫院","郵遞區號":"81357","_id":8,"機構地址":"高雄市左營區嘉慶街46號","機構電話":"07-5584913"},{"機構名稱":"大社家畜醫院","郵遞區號":"81541","_id":9,"機構地址":"高雄市大社區三民路244號","機構電話":"07-3517741"},{"機構名稱":"大眾動物醫院","郵遞區號":"82050","_id":10,"機構地址":"高雄市岡山區大義二路72號","機構電話":"07-6255802"}],"_links":{"start":"/api/action/datastore_search?limit=10&resource_id=b5d645b6-b7a5-46a3-98b1-993f14dbd1a3","next":"/api/action/datastore_search?offset=10&limit=10&resource_id=b5d645b6-b7a5-46a3-98b1-993f14dbd1a3"},"limit":10,"total":207}
     */
    private String help;
    private boolean success;
    private ResultBean result;

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * resource_id : b5d645b6-b7a5-46a3-98b1-993f14dbd1a3
         * fields : [{"type":"int4","id":"_id"},{"type":"text","id":"機構名稱"},{"type":"text","id":"機構電話"},{"type":"numeric","id":"郵遞區號"},{"type":"text","id":"機構地址"}]
         * records : [{"機構名稱":"一嘉動物醫院","郵遞區號":"80243","_id":1,"機構地址":"高雄市苓雅區興中一路383號","機構電話":"07-3318123"},{"機構名稱":"人人動物醫院","郵遞區號":"83154","_id":2,"機構地址":"高雄市大寮區鳳林三路827號","機構電話":"07-7830515"},{"機構名稱":"人愛動物醫院","郵遞區號":"80048","_id":3,"機構地址":"高雄市新興區六合一路30號","機構電話":"07-2371276"},{"機構名稱":"十銓動物醫院","郵遞區號":"80752","_id":4,"機構地址":"高雄市三民區十全二路99號","機構電話":"07-3113797"},{"機構名稱":"三和台大動物醫院","郵遞區號":"80253","_id":5,"機構地址":"高雄市苓雅區光華一路23號","機構電話":"07-3383828"},{"機構名稱":"上揚動物醫院","郵遞區號":"80242","_id":6,"機構地址":"高雄市苓雅區林森二路7之2號","機構電話":"07-3391010"},{"機構名稱":"凡賽爾動物醫院","郵遞區號":"83092","_id":7,"機構地址":"高雄市鳳山區五甲二路399號","機構電話":"07-7613995"},{"機構名稱":"大其動物醫院","郵遞區號":"81357","_id":8,"機構地址":"高雄市左營區嘉慶街46號","機構電話":"07-5584913"},{"機構名稱":"大社家畜醫院","郵遞區號":"81541","_id":9,"機構地址":"高雄市大社區三民路244號","機構電話":"07-3517741"},{"機構名稱":"大眾動物醫院","郵遞區號":"82050","_id":10,"機構地址":"高雄市岡山區大義二路72號","機構電話":"07-6255802"}]
         * _links : {"start":"/api/action/datastore_search?limit=10&resource_id=b5d645b6-b7a5-46a3-98b1-993f14dbd1a3","next":"/api/action/datastore_search?offset=10&limit=10&resource_id=b5d645b6-b7a5-46a3-98b1-993f14dbd1a3"}
         * limit : 10
         * total : 207
         */

        private String resource_id;
        private LinksBean _links;
        private int limit;
        private int total;
        private List<FieldsBean> fields;
        private List<RecordsBean> records;

        public String getResource_id() {
            return resource_id;
        }

        public void setResource_id(String resource_id) {
            this.resource_id = resource_id;
        }

        public LinksBean get_links() {
            return _links;
        }

        public void set_links(LinksBean _links) {
            this._links = _links;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<FieldsBean> getFields() {
            return fields;
        }

        public void setFields(List<FieldsBean> fields) {
            this.fields = fields;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class LinksBean {
            /**
             * start : /api/action/datastore_search?limit=10&resource_id=b5d645b6-b7a5-46a3-98b1-993f14dbd1a3
             * next : /api/action/datastore_search?offset=10&limit=10&resource_id=b5d645b6-b7a5-46a3-98b1-993f14dbd1a3
             */

            private String start;
            private String next;

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getNext() {
                return next;
            }

            public void setNext(String next) {
                this.next = next;
            }
        }

        public static class FieldsBean {
            /**
             * type : int4
             * id : _id
             */
            private String type;
            private String id;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class RecordsBean {
            /**
             * 機構名稱 : 一嘉動物醫院
             * 郵遞區號 : 80243
             * _id : 1
             * 機構地址 : 高雄市苓雅區興中一路383號
             * 機構電話 : 07-3318123
             */

            private String 機構名稱;
            private String 郵遞區號;
            private int _id;
            private String 機構地址;
            private String 機構電話;

            public String get機構名稱() {
                return 機構名稱;
            }

            public void set機構名稱(String 機構名稱) {
                this.機構名稱 = 機構名稱;
            }

            public String get郵遞區號() {
                return 郵遞區號;
            }

            public void set郵遞區號(String 郵遞區號) {
                this.郵遞區號 = 郵遞區號;
            }

            public int get_id() {
                return _id;
            }

            public void set_id(int _id) {
                this._id = _id;
            }

            public String get機構地址() {
                return 機構地址;
            }

            public void set機構地址(String 機構地址) {
                this.機構地址 = 機構地址;
            }

            public String get機構電話() {
                return 機構電話;
            }

            public void set機構電話(String 機構電話) {
                this.機構電話 = 機構電話;
            }
        }
    }
}
