# googleChartHtmlLoader
This in a sample app that can populate a chart provide by google chart with json data. The chart itself is wrapped as in-project html file, which is located inside assets folder. This project utilize Google Chart to drawt the chart.

## Deep Dive
You can take a look first at MainActivity.kt then go to app/src/main/assets

### MainActivity.kt
A pretty simple activity which control much everything this apps do. You can take a look at `onCreate` function.

```
//onCreate() snippet

 json = JsonObject().apply {
            addProperty("Mushroom",5)
            addProperty("Cheese",2)
            addProperty("Pepperoni",3)
            addProperty("Tuna",4)
            addProperty("Chicken",3)
        }
        
 myWebView.settings.javaScriptEnabled = true
 myWebView.loadUrl("file:///android_asset/piechart.html?$json");
 
```

I declare `json` variable as `any` first. Here above i construct a JSON object and assign it to `json` variable i declare before. You can get your own JSON from somewhere else. After `json` value assigned, i embed it at url using `myWebView.loadUrl()` to pass the json to html file. The `json` that will be passed should be something like this :

```
{
   "Mushroom":5,
   "Cheese":2,
   "Pepperoni":3,
   "Tuna":4,
   "Chicken":3
}
```

### app/src/main/assets

Here isn't exactly a file, it is a folder and you fill find 3 .html file. These three files obviously not so different, let's take a look first at `piechart.html`. In case you didn't know, this html file can be opened using text editor and that's what i do. See the snippet code of that file, particularly `drawChart()` function.

```
//drawChart() snippet

var decodeUrl = decodeURI(document.location.href);
var jsonStr = decodeUrl.split("?")[1];
var json = JSON.parse(jsonStr);
var dataArray = Object.entries(json)
var data = new google.visualization.DataTable();

data.addColumn('string', 'Topping');
data.addColumn('number', 'Slices');
data.addRows(dataArray);
        
var options = {'title':'How Much Pizza I Ate Last Night'};
var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
chart.draw(data, options);

 ```
 
 The file written in both html and javascript. It might be a bit intimidating first but let us breakdown it. The goal is to create an array like this :
 
 ```
 [
   ['Mushrooms', 3],
   ['Onions', 1],
   ['Olives', 1],
   ['Zucchini', 1],
   ['Pepperoni', 2]
 ]
 ```
 
The array itself a mandatory for google chart to draw the charts. You can take a look at [Google Chart Quick Start](https://developers.google.com/chart/interactive/docs/quick_start) to get more insight about the chart. Remember before, we have passed json object from activity to this html. The json will be converted to array, then it will be passed to ```data``` variable using ```data.addRow```. The methods is similiar for every chart type (which stored in different html file).
 
 
 

