//SORTING ALGORITHMS

const testSort = () => {
  const testArr = [4, 3, 6, 8, 3, -9, 0, 3, 6];
  var insert = insertionSort(testArr);
  var selection = selectionSort(testArr);
  var merge = mergeSort(testArr);

  console.log("Array after sorted: ", merge);
};

/**
 * Go through each element in the array from left to right and place it in the right order
 */
const insertionSort = (array) => {
  var j;
  for (j = 1; j < array.length; j++) {
    var key = array[j];
    var i = j - 1;
    while (i >= 0 && array[i] > key) {
      array[i + 1] = array[i];
      i = i - 1;
    }
    array[i + 1] = key;
  }
  return array;
};

const selectionSort = (array) => {
  for (var i = 0; i < array.length; i++) {
    var minIdx = i;

    for (var j = i + 1; j < array.length; j++) {
      if (array[j] < array[minIdx]) {
        minIdx = j;
      }
    }

    //swap the numbers
    var temp = array[i];
    array[i] = array[minIdx];
    array[minIdx] = temp;
  }

  return array;
};

const merge = (array, startIdx, midIdx, endIdx) => {
  var len1 = midIdx - startIdx + 1;
  var len2 = endIdx - midIdx;

  const lowHalf = [0] * len1;
  const highHalf = [0] * len2;

  for (var i = 0; i < len1; i++) {
    lowHalf[i] = array[startIdx + i];
  }

  for (var j = 0; j < len2; j++) {
    highHalf[j] = array[midIdx + j + 1];
  }

  var k = startIdx;
  var i = 0;
  var j = 0;

  while (i < len1 && j < len2) {
    if (lowHalf[i] <= highHalf[j]) {
      array[k] = lowHalf[i];
      i++;
    } else {
      array[k] = highHalf[j];
      j++;
    }
    k++;
  }

  while (i < len1) {
    array[k] = lowHalf[i];
    k++;
    i++;
  }
  while (j < len2) {
    array[k] = highHalf[j];
    k++;
    j++;
  }

  return array;
};

const mergeSort = (array, startIdx, endIdx) => {
  var midIdx = Math.floor((startIdx + endIdx) / 2);

  if (startIdx < endIdx) {
    mergeSort(array, startIdx, endIdx);
    mergeSort(array, midIdx + 1, endIdx);
    merge(array, startIdx, midIdx, endIdx);
  }
  return array;
};

testSort();
