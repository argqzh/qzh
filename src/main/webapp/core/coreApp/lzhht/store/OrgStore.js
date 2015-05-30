/*
 *  
 */
Ext.define("core.lzhht.store.OrgStore", {
  extend: 'Ext.data.TreeStore',
  defaultRootId: "root",
  storeId: 'orgStoreId_lzhht',
  //autoSync:true,//与服务器同步
  proxy: {
    api: {
    },
    type: "ajax",
    url: "./org/list_org_tree.do",
    reader: {
      type: "json"
    },
    writer: {
      type: "json"
    }
  },
  autoLoad: true
});