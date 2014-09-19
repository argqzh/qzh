Ext.define("core.controller.MapController", {
//	mixins:{
//		gridUtils:"core.utils.GridUtils"
//	},
//	
  extend: "Ext.app.Controller",
  init: function() {
    var self = this;
    this.control({
      /**showbefor*/
      "mapLayout": {
        beforeshow: function(layout, opt) {
          //alert(layout.getXType());
//          var grid = layout.down("product_grid");
//          var store = grid.getStore();
//          store.filter("id", 0);
        }
      },
      "orgTreeMap": {
        itemclick: function(tree, record, item, index, e, eOpts) {
          
        }
      }

    });
  },
  views: [
    "core.view.MapLayout",
    "core.view.OrgTreeMap"
  ],
  stores: ["core.store.OrgStore"],
  models: []
});