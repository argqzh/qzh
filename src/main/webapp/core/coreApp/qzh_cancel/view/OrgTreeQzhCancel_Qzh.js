/**
 *  
 */
Ext.define("core.qzh_cancel.view.OrgTreeQzhCancel_Qzh", {
  extend: "Ext.tree.Panel",
  alias: "widget.orgTreeQzh_QzhCancel",
  rootVisible: false, // 不展示根节点
  displayField: "text",
  animate: false, // 去掉一些动画效果
  store: "core.qzh_cancel.store.OrgStore_QzhCancel_Qzh",
  tools: [{
      type: 'refresh',
      qtip: '刷新',
      handler: function(event, toolEl, header) {
        header.ownerCt.getStore().reload();
      }
    }]
});