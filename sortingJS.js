//SORTING ALGORITHMS

/**
 * Go through each element in the array from left to right and place it in the right order
 */
const insertionSort = (array) => {
  var j;
  for (j = 1; j < array.length; j++) {
    var key = array[j];
    var i = j - 1;
    while (i >= 0 && array[i] < key) {
      array[i + 1] = arr[i];
      i = i - 1;
    }
    array[i + 1] = key;
  }
  return array;
};
